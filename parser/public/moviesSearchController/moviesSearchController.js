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
                    video : row.m_video
                });
            });
            res.send(JSON.stringify(apiRes));
        },
        () => {
            res.send(JSON.stringify(apiRes));
        });
    }
}