var readlineSync = require("readline-sync");
const { readFile } = require("fs");

var filename = readlineSync.question("Give file name: ");

readFile(filename, "utf-8", (err, data) => {
  if (data != null) {
    console.log("The content of the file is:");
    console.log(data);
  }
});
