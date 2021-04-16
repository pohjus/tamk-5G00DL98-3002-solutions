class Person {
  constructor(name) {
    this.name = name;
  }

  hello = () => {
    console.log(`hello ${this.name}`);
  };

  delayedHello() {
    setTimeout(this.hello, 1000);
  }
}
let jack = new Person("jack");
jack.delayedHello();
