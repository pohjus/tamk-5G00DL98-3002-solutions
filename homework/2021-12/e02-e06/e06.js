// let user = {
//   name: "Jack",
//   sayHello: function () {
//     console.log(`Hello, ${this.name}!`);
//   },
//   sayDelayedHello: function () {
//     // let f = this.sayHello
//     let f = user.sayHello;
//     setTimeout(f, 1000);
//   },
// };
// user.sayHello();
// user.sayDelayedHello();

// let user = {
//   name: "Jack",
//   sayHello: function () {
//     console.log(`Hello, ${this.name}!`);
//   },
//   sayDelayedHello: function () {
//     setTimeout(this.sayHello, 1000);
//   },
// };
// user.sayHello();
// user.sayDelayedHello();

// => Still undefined

function helper() {
  user.sayHello();
}
let user = {
  name: "Jack",
  sayHello: function () {
    console.log(`Hello, ${this.name}!`);
  },
  sayDelayedHello: function () {
    setTimeout(helper, 1000);
  },
};
user.sayHello();
user.sayDelayedHello();

/* Now it works because the helper function handles the call 
   and can use the object notation to retain the context of the user object */
