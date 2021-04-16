function makeCalculation(num1, num2) {
  function asynFunc(resolve, reject) {
    if (num2 === 0) {
      reject("cannot divide with zero.");
    } else {
      setTimeout(() => {
        console.log("calculating stuff");
        const division = num1 / num2;
        resolve(division);
      }, 1000);
    }
  }
  const p = new Promise(asynFunc);
  return p;
}

function sendStuffToBackend(result) {
  function asynFunc(resolve, reject) {
    const random = Math.floor(Math.random() * 2);

    if (random === 0) {
      reject("failed to connect to backend.");
    } else {
      setTimeout(() => {
        console.log(`sending to backend ${result}`);
        resolve("done");
      }, 1000);
    }
  }
  const p = new Promise(asynFunc);
  return p;
}

makeCalculation(10, 5)
  .then((sum) => sendStuffToBackend(sum))
  .then((msg) => console.log(msg))
  .catch((errormsg) => console.log(errormsg));
