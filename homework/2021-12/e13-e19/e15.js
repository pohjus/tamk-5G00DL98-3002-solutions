function Person(name) {
  this.name = name;
}
Person.prototype.drinkBeer = function () {
  console.log(this.name + " drinks beer");
};

let jack = new Person("jack");
jack.drinkBeer();
let tina = new Person("tina");
tina.drinkBeer();

function Programmer(name, salary) {
  // this.name = name;
  Person.call(this, name);
  this.salary = this.salary; // shouldn't the second one be just salary?
}
Programmer.prototype.codeApps = function () {
  console.log(this.name + " implements apps");
};
let hannah = new Programmer("hannah", 4000);
hannah.codeApps();

Object.setPrototypeOf(Programmer.prototype, Person.prototype);

hannah.drinkBeer();
