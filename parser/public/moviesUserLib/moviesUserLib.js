module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        const userId = 1;
        let apiRes = [];
        db.dbrequest("SELECT * FROM orders LEFT JOIN users ON orders.order_user_id = users.user_id LEFT JOIN movies ON orders.order_movie_id=movies.m_id WHERE users.user_id = 1 ORDER BY order_utc_end DESC").then((data)=>{
            data.map((row) => {
                apiRes.push({
                    id: row.order_id,
                    movie_id: row.order_movie_id,
                    title: row.mdb_titile,
                    description: row.mdb_descr,
                    image: row.mdb_image,
                    video : row.m_video,
                    end: row.order_utc_end,
                    status: row.order_status,
                });
            });
            res.send(JSON.stringify(apiRes));
        },
        () => {
            res.send(JSON.stringify(apiRes));
        });
        
    }
}
