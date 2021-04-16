var readlineSync = require("readline-sync");
const fs = require("fs");
const util = require("util");
const readFile = util.promisify(fs.readFile);

var fileName = readlineSync.question("Give file name: ");

// readFile(fileName, "utf-8").then((data) => console.log(data));

readFile(fileName, "utf-8")
  .then(parseJson)
  .then((name) => console.log(name))
  .catch((msg) => console.log(msg));

function parseJson(data) {
  function func(resolve, reject) {
    // parse the data (do not implement try catch, if exception occurs, this
    // will be catched automatically in your catch outside of this function.
    // if name is found from obj, call resolve, otherwise call reject
    const obj = JSON.parse(data);
    if ("name" in obj) {
      resolve(obj.name);
    } else {
      reject(`file ${fileName} contains json but not property name`);
    }
  }
  const p = new Promise(func);
  return p;
}
