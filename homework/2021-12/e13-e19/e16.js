let obj = { name: "jussi" };

function Dog(name) {
  this.name = name;
  this.sniffButt = this.sniffButt.bind(this);
}

Dog.prototype.sniffButt = function () {
  console.log(this.name + " sniffs butt");
};

let spot = new Dog("spot");
let vilma = new Dog("vilma");
spot.sniffButt();
vilma.sniffButt();

// How many times is the sniffButt in memory?
// - Just once since it's in the prototype?

Dog.prototype.delayedSniffButt = function () {
  setTimeout(this.sniffButt, 1000);
};

spot.delayedSniffButt();
vilma.delayedSniffButt();

// Assigning the hello world function to this.sniffButt overrides the prototype one

// Binding it to the jussi object, well, binds it to jussi
// So now only jussi can sniff butt

// Binding it to "this" binds it to whichever object is being created
// -> now it works as intended
