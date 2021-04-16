// e10
console.log("e10");

function Person(name, age) {
  this.name = name;
  this.age = age;
}
var tina = new Person("Tina", 20);

console.log(tina);

// e11
console.log("\ne11");

const max = (a, b) => {
  if (a >= b) return a;
  else return b;
};

console.log(max(4, 6));

// e12
console.log("\ne12");

const isPositiveInteger = (value, onSuccess, onError) => {
  if (value > 0) {
    onSuccess();
  } else {
    onError();
  }
};

const success = () => {
  console.log("Success!");
};
const failure = () => {
  console.log("Failure!");
};
isPositiveInteger(4, success, failure);
isPositiveInteger(-4, success, failure);

// e13
console.log("\ne13");
isPositiveInteger(
  0,
  function () {
    console.log("Success!");
  },
  function () {
    console.log("Failure!");
  }
);

// e14
console.log("\ne14");
isPositiveInteger(
  0.0000001,
  () => {
    console.log("Success!");
  },
  () => {
    console.log("Failure!");
  }
);

// e15
console.log("\ne15");

const repeat = (word, count = 1) => {
  let str = "";
  for (let i = 0; i < count; i++) {
    str += word;
  }
  return str;
};

console.log(repeat("moi")); // outputs "moi"
console.log(repeat("moi", 4)); // outputs "moimoimoimoi"

// e16
console.log("\ne16");

function doIt() {
  console.log("hello");
}
console.log(typeof doIt); // function - doIt is a function
console.log(doIt instanceof Function); // true - it is an instance of the Function class

// typeof can return: boolean, function, object, number, bigint, string, undefined, symbol
// instanceof checks if the type matches the given (base) class

// e17
console.log("\ne17");

// A function object is created with no parameters ("") and the functionality 'console.log("hello")'
var myFunc = new Function("", 'console.log("hello")');
// Function objects have a member method "call" that invokes their functionality
myFunc.call();

// e18
console.log("\ne18");
const doIt2 = (...args) => {
  console.log(args.join(""));
};
doIt2("a"); // outputs a
doIt2("a", "b"); // outputs ab
doIt2("a", "b", "c"); // outputs abc
