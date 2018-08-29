var fs = require('fs');
var path = "phantom.html";
fs.write(path, 'hello', 'w');
phantom.exit();
