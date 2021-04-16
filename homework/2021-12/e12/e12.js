function Clock() {
  this.time = new Date().toString();
  this.startInterval = function () {
    // Original
    // setInterval(this.tick, 1000);
    // ------------------------------
    // Case 1 - Closures and anonymous inner function
    // let _this = this;
    // setInterval(function () {
    //   _this.tick();
    // }, 1000);
    // ------------------------------
    // Case 2 - Arrow syntax
    // setInterval(() => this.tick(), 1000);
    // ------------------------------
    // Case 3 - Function binding
    setInterval(this.tick.bind(this), 1000);
  };
  this.tick = function () {
    this.time = new Date().toString();
    console.log(this.render());
  };
  this.render = function () {
    return this.time;
  };
}

let clock = new Clock();
console.log(clock.render()); // outputs time
clock.startInterval(); // outputs time for every second, uses render
