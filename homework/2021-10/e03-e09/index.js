/* eslint-disable no-unused-vars */

// e03
console.log("e03");
var v = "var";
let l = "let";
const c = "const";

if (true) {
  var v = "var in if";
  let l = "let in if";
  const c = "const in if";
}

console.log(v);
console.log(l);
console.log(c);

// e04
console.log("\ne04");

let a = 1;
let x = "'string'";
a++;
let y = '"string"';
a++;
let z = `str${a}
ing`;

console.log(x);
console.log(y);
console.log(z);

// I was going to do 'str' === "str", but Prettier won't let me
const result = `str"ing` === 'str"ing';
console.log("`str\"ing` === 'str\"ing' : " + result);

// e05
console.log("\ne05");
let cars = ["Audi", "Volvo", "BMW"];

for (const car in cars) {
  console.log(car);
}

for (const car of cars) {
  console.log(car);
}

// e06
console.log("\ne06");
var person = { name: "Ben", age: 40, height: 180, mass: 80 };
for (const key in person) {
  console.log(key + ": " + person[key]);
}

// e07
console.log("\ne07");
process.argv.forEach((arg, index) => {
  if (index > 1) console.log(arg);
});

// e08
console.log("\ne08");
const args = process.argv;
if (args.length == 4) {
  const n1 = Number(args[2]);
  const n2 = Number(args[3]);
  if (isNaN(n1) || isNaN(n2)) {
    console.log("At least one of the arguments is not a number.");
  } else {
    console.log(n1 + n2);
  }
}

// e09
console.log("\ne09");

function abs(num) {
  if (num < 0) return num * -1;
  else return num;
}
console.log(abs(-7)); // outputs 7
console.log(abs(7)); // outputs 7
