import React from "react";
import { Text } from "react-native";

export default function Counts({ matches, weeks }) {
  return (
    <Text>
      You got {matches} correct, it took {Math.floor(weeks / 52)} years ({weeks}{" "}
      weeks).
    </Text>
  );
}
