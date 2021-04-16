// class Person {
//   constructor(name) {
//     this.name = name;
//   }
//   drinkBeer() {
//     console.log(this.name + " drinks beer");
//   }
//   sayHello() {
//     console.log("hello from " + this.name);
//   }
// }

class Person {
  constructor(name) {
    this.name = name;
    this.drinkBeer = function () {
      console.log(this.name + " drinks beer");
    };
  }
  sayHello() {
    console.log("hello from " + this.name);
  }
}

let jack = new Person("jack");
jack.sayHello();
let tina = new Person("tina");
tina.sayHello();

// Is drinkBeer and sayHello now twice in memory or only one time?
// - One time

// Does "Person.prototype" hold the following functions?
Person.prototype.sayHello();
// Person.prototype.drinkBeer();
// - Yes

// After the changes: Is drinkBeer now two times in memory or only one time?
// - Twice, and it's no longer in the prototype
