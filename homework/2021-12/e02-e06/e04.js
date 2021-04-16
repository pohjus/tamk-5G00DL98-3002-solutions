let user = {
  name: "Jack",
  sayHello: function () {
    console.log(`Hello, ${this.name}!`);
  },
};

user.sayHello();

let f = user.sayHello;
f(); // Hello, undefined!

setTimeout(user.sayHello, 1000);
// Same reason as e01
// It copies the function without the context, so "this" will be the global object

function sayHello() {
  user.sayHello();
}
setTimeout(sayHello, 1000);
// Works because the context of user.sayHello is established inside the wrapper function

setTimeout(() => user.sayHello(), 1000);
// Works because arrow functions are bros

user.sayHello = function () {
  console.log("does it work?");
};
// It appears to change the last two queued function calls
// The first one was presumably copied on call, so it can't change
// The other two are inside wrapper functions, so they are resolved when called
