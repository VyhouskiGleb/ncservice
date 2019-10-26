const routes = require('../routes.json');

module.exports = function(app, db) {
    routes.forEach(function(rote) {
        
        let routerAction = new Router();
        routerAction.fileSystemWorker(app, db, rote);

        switch(rote.method){
            case 'get':
                routerAction.getRoute(app, db, rote);
            break;
            case 'post':
                routerAction.postRoute(app, db, rote);
            case 'all':
                routerAction.allRoute(app, db, rote);
            break;
                default:
            break;
        } 
    });
}


class Router{
    getRoute(app, db, rote){
        return app.get(rote.rote, (req, res) => {
            this.connector(app, db, rote, req, res);
        });
    }

    postRoute(app, db, rote){
        return app.post(rote.rote, (req, res) => {
            this.connector(app, db, rote, req, res);
        });
    }

    allRoute(app, db, rote){
        return app.all(rote.rote, (req, res) => {
            this.connector(app, db, rote, req, res);
        });
    }

    connector(app, db, rote, req, res){
        let controllerModule = require('../public/'+rote.controller+'/'+rote.controller+'.js');
        let controller = new controllerModule();
        controller.controllerRun(app, db, rote, req, res);  
    }

    fileSystemWorker(app, db, rote){
        var fs = require('fs');

        fs.stat('./public/'+rote.controller+'/'+rote.controller+'.js', (err, stats) => {
            if(!stats){
                let mkdirp = require('mkdirp');
                mkdirp('./public/'+rote.controller, function (err) {
                    if (err) console.error(err)
                });
                mkdirp('./public/'+rote.controller+'/models', function (err) {
                    if (err) console.error(err)
                });
                let controllerData = "module.exports = class authController {\n    controllerRun(app, db, rote, req, res) {\n        res.send(JSON.stringify('"+rote.controller+"'));\n        return true;\n    }\n}";
                fs.writeFile('./public/'+rote.controller+'/'+rote.controller+'.js', controllerData, function(err) {
                        if(err) throw err;
                        console.log(rote.controller+" created!");
                    });
                    
            }
        });
    }
}