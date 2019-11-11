module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        let apiRes = [];
        let end = 0;
        if(req.query.end === undefined) end = 9;
        else end = req.query.end;
        console.log(req.query.end)
        db.dbrequest("SELECT * FROM movies ORDER BY m_id DESC LIMIT 0, "+end).then((data)=>{
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
            res.send(JSON.stringify(apiRes));
        });
        
        return true;
    }
}
