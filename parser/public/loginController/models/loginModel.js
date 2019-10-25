const md5 = require('md5');
var ReverseMd5 = require('reverse-md5');

module.exports = class loginModel {
    login(db, login = '', password = '') {
        return new Promise((resolve, reject) => {
            const passwordToken = md5(password);

            db.dbrequest("SELECT * FROM users WHERE user_login = '"+login+"' AND user_password = '"+passwordToken+"'").then(
                (data)=>{
                    this.check(db, this.outputData(data).token).then((checked)=>{ console.log(checked)});
                    resolve(this.outputData(data));
                    console.log(this.outputData(data));
                },
                ()=>{reject('LoginModel: Database req error')}
            );
        });
    }

    outputData(data){
        let loginStatus;
        let currentToken;
        let currentId;
        if(data[0] !== undefined){
            currentToken = this.generateToken(data[0]);
            loginStatus = true;
            currentId = data[0].user_id;
        }else{
            currentToken = '';
            loginStatus = false;
            currentId = 0;
        }
        return {
            status: loginStatus,
            token: currentId + '.' + currentToken,
        }
    }

    check(db, data){
        return new Promise((resolve, reject) => {
            if(data.token === null) resolve(false);

            const inputToken = data.split(".");

            if(inputToken.length < 2) resolve(false);
            const userId = inputToken[0];            
        
            db.dbrequest("SELECT * FROM users WHERE user_id= '"+userId+"'").then(
                (responceData)=>{
                    if(responceData[0] === undefined) resolve(false);
                    let token = this.generateToken(responceData[0]);
                    if(userId + '.' + token === data) resolve(true);
                    else resolve(false);
                },
                ()=>{reject('LoginModel: Database req error')}
            );
        });
    }

    generateToken(data) { 
        return md5(data.user_login+'.'+data.user_id+'.'+data.user_lastlogin)
    }
}