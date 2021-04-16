function Person(name) {
  this.name = name;
  this.sayHello = function () {
    console.log(`Hello, ${this.name}!`);
  };
  this.sayDelayedHello = function () {
    setTimeout(this.sayHello, 1000);
  };
  // INSERT CODE HERE
  this.sayHello = this.sayHello.bind(this); // ??? XD
}
let jack = new Person("jack");
jack.sayDelayedHello();
let tina = new Person("tina");
tina.sayDelayedHello();
