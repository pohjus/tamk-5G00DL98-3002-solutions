import React, { useState } from "react";
import { Text, View, Button, TouchableOpacity } from "react-native";

export default function NumberButton({
  styles,
  toggle,
  id,
  toggled,
  highlighted,
}) {
  const colorOn = "#C7C4C8";
  const colorOff = "#FFFFDE";
  const colorHighlight = "red";
  // If button is highlighted, show that colour, otherwise follow toggle state
  const buttonColor = highlighted
    ? colorHighlight
    : toggled
    ? colorOn
    : colorOff;
  const handleToggle = () => {
    toggle(id, toggled);
  };

  return (
    <>
      <TouchableOpacity
        style={{ ...styles.roundButton, backgroundColor: buttonColor }}
        onPress={handleToggle}
        type={toggled ? "outline" : "solid"}
      >
        <Text>{id}</Text>
      </TouchableOpacity>
    </>
  );
}
