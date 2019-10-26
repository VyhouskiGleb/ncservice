const express        = require('express');
const bodyParser     = require('body-parser');
const app            = express();
var cors = require('cors');
const Core           = require('./application/Core.js');

const core = new Core();
const db = core.database();

app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
})); 

app.use(cors());

require('./application/run.js')(app, db);
console.log('this is server');
core.run(app);