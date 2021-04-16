console.log("Hello World!");

var generate = require("project-name-generator");
var readlineSync = require("readline-sync");

console.log(generate().dashed);

var num1 = readlineSync.questionInt("First number: ");
var num2 = readlineSync.questionInt("Second number: ");
console.log(num1 + num2);
