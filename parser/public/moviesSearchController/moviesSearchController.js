module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        let apiRes = [];
        let string = '';
        if(req.query.string === undefined) string = '';
        else string = req.query.string;
      
        db.dbrequest("SELECT * FROM movies WHERE mdb_titile LIKE '%"+string+"%' OR mdb_descr LIKE '%"+string+"%' ORDER BY m_id DESC").then((data)=>{
            data.map((row) => {
                apiRes.push({
                    id: row.m_id,
                    title: row.mdb_titile,
                    description: row.mdb_descr,
                    image: row.mdb_image,
                    cost: 333,
                    video : row.m_video
                });
            });
                res.setHeader('Content-Type', 'application/json');
            res.send(JSON.stringify(apiRes));
        },
        () => {
            res.setHeader('Content-Type', 'application/json');
            res.send(JSON.stringify(apiRes));
        });
    }
}
