class Dog {
  constructor(name) {
    this.name = name;
    this.sniffButt = this.sniffButt.bind(this); // still required!
  }
  sniffButt() {
    console.log(this.name + " sniffs butt");
  }
  delayedSniffButt() {
    setTimeout(this.sniffButt, 1000);
  }
}

let spot = new Dog("spot");
let vilma = new Dog("vilma");
spot.sniffButt();
vilma.sniffButt();

spot.delayedSniffButt();
vilma.delayedSniffButt();
