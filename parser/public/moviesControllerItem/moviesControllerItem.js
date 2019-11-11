module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        let apiRes = null;
        let id = 0;
        if(req.query.id === undefined) id = 0;
        else id = req.query.id;
        db.dbrequest("SELECT * FROM movies WHERE m_id="+id+" ORDER BY m_id DESC ").then((data)=>{
                    if(data.length !== 0) apiRes={
                        id: data[0].m_id,
                        title: data[0].mdb_titile,
                        description: data[0].mdb_descr,
                        image: data[0].mdb_image,
                        cost: 333,
                        video : data[0].m_video
                    };
                res.setHeader('Content-Type', 'application/json');
                res.send(JSON.stringify(apiRes));
            },
            () => {
                res.send(JSON.stringify(apiRes));
            });

        return true;
    }
}
