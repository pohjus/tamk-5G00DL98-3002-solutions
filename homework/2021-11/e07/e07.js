/* eslint-disable no-unused-vars */
var readlineSync = require("readline-sync");
const fs = require("fs");
const util = require("util");
const readFile = util.promisify(fs.readFile);

/* Misread the instructions, saving for reference */

// async function readFileAndParse(fileName) {
//   const data = await readFile(fileName, "utf-8");

//   const obj = await JSON.parse(data);
//   if ("name" in obj) {
//     return obj.name;
//   } else {
//     throw `file ${fileName} contains json but not property name`;
//   }
// }

function parseJson(data) {
  function func(resolve, reject) {
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

async function readFileAndParse(fileName) {
  const data = await readFile(fileName, "utf-8");
  return await parseJson(data);
}

var fileName = readlineSync.question("Give file name: ");

readFileAndParse(fileName)
  .then((name) => console.log(name))
  .catch((msg) => console.log(msg));
// .then(() => console.log("test"));
