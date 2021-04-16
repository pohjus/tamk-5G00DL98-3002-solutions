class Person {
  constructor(name) {
    this.name = name;
    let _this = this;
    this.hello = function () {
      console.log(`hello ${_this.name}`);
    };
  }

  delayedHello() {
    setTimeout(this.hello, 1000);
  }
}
let jack = new Person("jack");
jack.delayedHello();
