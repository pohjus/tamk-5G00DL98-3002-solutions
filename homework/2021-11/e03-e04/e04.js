var readlineSync = require("readline-sync");
const { readFile } = require("fs");

var filename = readlineSync.question("Give file name: ");

readFile(filename, "utf-8", (err, data) => {
  if (data != null) {
    try {
      const obj = JSON.parse(data);
      if ("name" in obj) {
        console.log(obj.name);
      } else {
        console.log(`file ${filename} contains json but not property name`);
      }
    } catch (error) {
      console.log(`file ${filename} does not contain json`);
    }
  } else {
    console.log(`file ${filename} does not exist.`);
  }
});
