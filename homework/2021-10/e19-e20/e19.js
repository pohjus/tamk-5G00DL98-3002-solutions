const { readFile, writeFile } = require("fs");

const args = process.argv;
if (args.length > 2) {
  const sourceFile = args[2];

  // Read file
  readFile(sourceFile, "utf-8", (err, data) => {
    if (err) {
      console.log(sourceFile);
      console.log("File could not be opened.");
      console.log(err);
    } else {
      console.log(data);

      // Write to destination if filename was given
      if (args.length > 3) {
        const destinationFile = args[3];
        writeFile(destinationFile, data, (err) => {
          if (err) {
            console.log("File could not be saved.");
            console.log(err);
          } else {
            console.log("Saved!");
          }
        });
      } else {
        console.log("No destination file provided.");
      }
    }
  });
}
