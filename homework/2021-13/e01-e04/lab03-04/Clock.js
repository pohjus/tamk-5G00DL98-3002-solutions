import React from "react";
import { Text, View, Button } from "react-native";
import moment from "moment";
import "moment/min/locales.min";

function Clock(props) {
  console.log(props);
  // let [time, setTime] = React.useState(new Date().toString());

  const locale = props?.locale?.toLowerCase() || "en";
  // console.log(locale);

  const [time, setTime] = React.useState(moment().locale(locale).format("LTS"));

  const updateTime = () => {
    setTime(moment().locale(locale).format("LTS"));
  };
  React.useEffect(() => {
    console.log("mounted");
    const id = setInterval(updateTime, 1000);
    return () => {
      console.log("unmounted");
      clearInterval(id);
    };
  }, [props.locale]);

  return (
    <View>
      <Text>{time}</Text>
      {/* <Button
        onPress={() => setTime(new Date().toString())}
        title="Update"
        color="#841584"
      /> */}
    </View>
  );
}

export default Clock;
