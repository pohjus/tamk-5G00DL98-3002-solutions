/* eslint-disable no-unused-vars */
const { readFile, writeFile } = require("fs");

const copy = async (src, dest) => {
  // Does this work? It was the only way I could find where it didn't return prematurely
  return new Promise((resolve, reject) => {
    // Read source file
    readFile(src, "utf-8", (err, data) => {
      if (err) {
        // console.log("error");
        // console.log(err);
        resolve("error"); // reject could go here, but this was easier
      } else {
        // Write to destination
        writeFile(dest, data, (err) => {
          if (err) {
            // console.log("error");
            // console.log(err);
            resolve("error");
          } else {
            // console.log("success");
            resolve("success");
          }
        });
      }
    });
  });
};

const args = process.argv;
if (args.length > 3) {
  const sourceFile = args[2];
  const destinationFile = args[3];

  copy(sourceFile, destinationFile).then((result) => console.log(result));
}
