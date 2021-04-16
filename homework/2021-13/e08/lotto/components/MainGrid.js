import React, { useState, useEffect } from "react";
import { Button, FlatList, Text, View } from "react-native";
import Counts from "./Counts";
import NumberButton from "./NumberButton";

export default function MainGrid({ styles }) {
  // User-chosen numbers
  const [numbersChosen, setNumbersChosen] = useState([]);
  // AI-chosen row
  const [numbersChosenByAI, setNumbersChosenByAI] = useState([]);
  const [lotteryRunning, setLotteryRunning] = useState(false);
  const [lotteryInterval, setLotteryInterval] = useState(null);
  const MAX_COUNT = 7;
  const MAX_VAL = 40;
  const numArr = [];
  for (var i = 1; i <= MAX_VAL; i++) {
    numArr.push(i);
  }

  const [weeks, setWeeks] = useState(0);
  const [matches, setMatches] = useState(0);
  let weeks2 = 0;

  // Returns a random integer between 1 and max
  const getRandomInt = (max) => {
    return Math.floor(Math.random() * max) + 1;
  };

  const getRandomLotteryRow = () => {
    const newLottery = [];
    while (newLottery.length < MAX_COUNT) {
      const newNum = getRandomInt(MAX_VAL);
      // If number is not a duplicate, add it
      if (newLottery.indexOf(newNum) === -1) {
        newLottery.push(newNum);
      }
    }
    return newLottery;
  };

  const checkLottery = (lotteryRow) => {
    let count = 0;
    // console.log(numbersChosenByAI);
    numbersChosen.forEach((num) => {
      if (lotteryRow.indexOf(num) > -1) {
        count++;
      }
    });
    // console.log("Matches: " + count);
    setMatches(count);

    // WIN!!
    // if (count > 2) {   // for testing
    if (count == MAX_VAL) {
      console.log("YOU WIN!!");
      clearInterval(lotteryInterval); // this doesn't work :/
      // console.log(lotteryInterval);
      setLotteryRunning(false);
    }
  };

  const drawLottery = () => {
    const newRow = getRandomLotteryRow();
    setNumbersChosenByAI(newRow);
    weeks2++;
    setWeeks(weeks2);
    // console.log("Drawing lottery...");
    // console.log(newRow);
    checkLottery(newRow);
  };

  const toggleLottery = () => {
    // Lottery not running -> start lottery
    if (!lotteryRunning) {
      setWeeks(0);
      setLotteryRunning(true);
      const interval = setInterval(drawLottery, 700); // lags too much at higher speeds
      setLotteryInterval(interval);
    }
    // Lottery running -> stop lottery
    else {
      setLotteryRunning(false);
      // console.log(lotteryInterval);
      clearInterval(lotteryInterval);
      setNumbersChosenByAI([]);
      // console.log("Stopping lottery...");
    }
  };

  const toggleButton = (id, selected) => {
    // console.log("Toggling button " + id);

    // Don't allow toggle during lottery
    if (!lotteryRunning) {
      if (selected) {
        const newNumbers = numbersChosen.filter((n) => n !== id);
        setNumbersChosen(newNumbers);
      } else if (!selected && numbersChosen.length < MAX_COUNT) {
        setNumbersChosen([...numbersChosen, id]);
      }
    }
  };

  useEffect(() => {
    return () => {
      clearInterval(lotteryInterval);
    };
  }, []);

  // Band-aid time!
  useEffect(() => {
    if (!lotteryRunning) {
      clearInterval(lotteryInterval);
    }
  }, [lotteryRunning]);

  return (
    <View style={styles.container}>
      <View style={styles.innerContainer}>
        <Text style={styles.title}>Lotto App</Text>
      </View>
      <View style={styles.innerContainer}>
        <Text>
          Choose your Lotto - {numbersChosen.length}/{MAX_COUNT}
        </Text>
      </View>
      <View style={styles.containerGrid}>
        <FlatList
          numColumns={5}
          data={numArr}
          keyExtractor={(item) => item.toString()}
          renderItem={({ item }) => {
            return (
              <NumberButton
                styles={styles}
                id={item}
                toggle={toggleButton}
                toggled={numbersChosen.indexOf(item) > -1}
                highlighted={numbersChosenByAI.indexOf(item) > -1}
              />
            );
          }}
        />
      </View>
      <View style={styles.innerContainer}>
        <Button
          title={lotteryRunning ? "Stop" : "Start"}
          onPress={toggleLottery}
          disabled={numbersChosen.length < MAX_COUNT}
        />
      </View>
      <View style={{ ...styles.innerContainer, marginBottom: 20 }}>
        <Counts matches={matches} weeks={weeks} />
      </View>
    </View>
  );
}
