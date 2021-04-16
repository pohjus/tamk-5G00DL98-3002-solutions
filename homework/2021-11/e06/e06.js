function makeCalculation(a, b) {
  function asynFunc(resolve, reject) {
    if (b === 0) {
      reject("cannot divide with zero.");
    } else {
      setTimeout(() => {
        console.log("calculating stuff");
        const division = a / b;
        resolve(division);
      }, 1000);
    }
  }
  const p = new Promise(asynFunc);
  return p;
}

function sendStuffToBackend(result) {
  function asynFunc(resolve, reject) {
    setTimeout(() => {
      console.log(`sending to backend ${result}`);
      resolve("done");
    }, 1000);
  }
  const p = new Promise(asynFunc);
  return p;
}

// async function makeCalculationAndSendStuffToBackend() {
//   return "hello world";
// }
//makeCalculationAndSendStuffToBackend().then((msg) => console.log(msg));

async function makeCalculationAndSendStuffToBackend() {
  // 1) make calculation
  const result = await makeCalculation(10, 2);
  // 2) send stuff to backend
  const msg = await sendStuffToBackend(result);
  // 3) inform that this is done
  return msg;
}

makeCalculationAndSendStuffToBackend().then((msg) => console.log(msg));
