const configuration = require('./config.json');
const mysql = require('mysql');
var imdbParser = require("imdb-parser");

const axios = require('axios');


module.exports = class Core{

    corssettings(app){
        var cors = new SetupCORS(app);
        return cors;
    }

    database(){
        var db = new Database();
        return db;
    }

    run(app){
        let parser = new ParserRuiner(4648786,4648787);
        parser.parse('6146586');

        var port = configuration.port;
        app.listen(port, () => {
            console.log('Server started ' + port);
        });
    }
}

class ParserRuiner {
    constructor (start, end) {
        this.startId = start;
        this.endId = end;
    }

    run() {
        let i = this.startId;
        let iterator = setInterval(()=>{
            this.parse(i);
            
            if(i >= this.endId) clearInterval(iterator);
            i++;
        }, 500)
    }
    parse(id) {
        console.log('http://www.omdbapi.com/?apikey=d51896da&i=tt'+id);
        axios.get('http://www.omdbapi.com/?apikey=d51896da&i=tt'+id).then((res)=>{
            const validationStatus = this.parserValidator(res.data);
            const responceData = res.data;
            if(validationStatus) this.check(res.data).then((res)=>{
                if(res) this.save(responceData);
            },
        ()=>{
            console.log('Parsing Error: movie has been already parsed');
        });
        }, (err) => {
            console.log('Parsing Error: client has been blocked');
        });
    }

    save(data) {
        const db = new Database();
        let dbQuery = 'INSERT INTO `movies` (`m_id`, `mdb_id`, `mdb_titile`, `mdb_released`, `mdb_genre`, `mdb_descr`, `mdb_image`, `m_video`) VALUES (NULL, "'+data.imdbID+'", "'+data.Title+'", "'+data.Released+'", "'+data.Genre+'", "'+data.Plot+'", "'+data.Poster+'", "bNJW113tbKk");';
        db.dbrequest(dbQuery).then(()=>{
            console.log("PARSING COMPLITE: " + data.Title);
        },
        (err)=>{
            console.log(err);
            console.log('Parsing Error: DB error');
        });
    }

    check(data) {
        return new Promise((resolve, reject) => {
            const db = new Database();
            let mdbID = data.imdbID;
            let dbQuery = "SELECT m_id FROM movies WHERE mdb_id='"+mdbID+"'";
            db.dbrequest(dbQuery).then((res)=>{
                if(res.length === 0) resolve(true);
                else reject(false);
            },
            ()=>{
                reject(false);
            }); 
        });
    }

    parserValidator(data) {
        let status = true;
        if(data.Type !== 'movie') status = false;
        if(parseInt(data.Runtime) < 45) status = false;
        if(data.Released === 'N/A' || data.Released === undefined) status = false;
        if(data.Poster === 'N/A' || data.Poster === undefined) status = false;
        if(status === false) console.log('Parsing warning: Not valid data');
        if(status) console.log(data);

        return status;
    }
}


class Database{

    createConnection(){
        return mysql.createConnection({
            database: configuration.database,
            host: configuration.host,
            user: configuration.user,
            password: configuration.password
        });
    }

    constructor(){
        this.dbrequest()   
    }

    dbrequest(sql = "SELECT 1"){
        return new Promise((resolve, reject) => {
            const connection = this.createConnection();
            connection.connect((err) => {
                if (err) {
                    reject(err)
                    console.log("MySQL: Connection Failed");
                } 
                connection.query(sql, function(err, rows, fields) {
                    if (err) reject(err);
                    connection.end();
                    console.log("MySQL: Status OK");
                    resolve(rows);
                });
                
            });
        });
    }
}
