module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        let apiRes = {counter: 0}
        db.dbrequest("SELECT COUNT(*) FROM movies").then((data)=>{
            apiRes = {counter: data[0]['COUNT(*)']}
            res.send(JSON.stringify(apiRes));
        },
        () => {
            res.send(JSON.stringify(apiRes));
        });
        
        return true;
    }
}