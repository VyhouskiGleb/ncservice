module.exports = class authController {
    controllerRun(app, db, rote, req, res) {
        res.send(JSON.stringify('indexController'));
        return true;
    }
}