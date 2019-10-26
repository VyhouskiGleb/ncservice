const model = require('./models/loginModel');
module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        var loginmodel = new model();
        loginmodel.login(db, req.body.login, req.body.password).then(
            (data) => {
                res.send(JSON.stringify(data));
            },
            (error) => {
                res.send(JSON.stringify(data));
            }
        );
        
        return true;
    }
}