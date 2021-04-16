// let user = {
//   name: "Jack",
//   sayHello: function () {
//     console.log(`Hello, ${this.name}!`);
//   },
//   sayDelayedHello: function () {
//     // setTimeout(function () {
//     //   this.sayHello();
//     // }, 1000);
//     setTimeout(() => {
//       this.sayHello();
//     }, 1000);
//   },
// };
// user.sayDelayedHello();

/* BABEL EDITION */
"use strict"; // strict mode

// let doesn't exist yet
var user = {
  name: "Jack",
  // Anonymous functions apparently don't exist yet
  sayHello: function sayHello() {
    // Backtick syntax doesn't exist yet
    console.log("Hello, ".concat(this.name, "!"));
  },
  sayDelayedHello: function sayDelayedHello() {
    var _this = this; // <--- save "this" for later
    // Arrow syntax doesn't exist yet
    setTimeout(function () {
      _this.sayHello(); // <- use "this" as the context
    }, 1000);
  },
};
user.sayDelayedHello();
