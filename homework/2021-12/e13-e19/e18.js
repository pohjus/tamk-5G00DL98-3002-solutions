String.prototype.isPalindrome = function () {
  let str = this.valueOf();
  let strReverse = str.split("").reverse().join("");

  if (str == strReverse) return true;
  else return false;
};

console.log("saippuakauppias".isPalindrome()); // true
console.log("abc".isPalindrome()); // false
