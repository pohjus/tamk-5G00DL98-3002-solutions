let user = {
  name: "Jack",
  sayHello: function () {
    // console.log(this);
    console.log(`Hello, ${this.name}!`);
  },
};

user.sayHello();

let myfunc = user.sayHello;
//myfunc = () => user.sayHello(); // <- this would work
myfunc(); // Hello, undefined!

// The context isn't copied on assignment, so "this" refers to the global object
// -> global.name doesn't exist -> undefined
