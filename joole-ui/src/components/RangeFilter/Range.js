import  React  from 'react';
import styles from './Range.module.css';

import 'rsuite/dist/styles/rsuite-default.css';
import { RangeSlider } from 'rsuite';

const Range = (props) => {
  
  const [value, setValue] = React.useState([props.min, props.max]);

  return (  
    <div className={styles.range}>
      <input
        className={styles.input}
        min={props.min}
        max={props.max}
        value={value[0]}
        onChange={nextValue => {
          const [start, end] = value;
          if (nextValue > end) return;
          setValue([nextValue, end]);
        }}/>

      <RangeSlider
        className={styles.slider}
        progress
        min={props.min}
        max={props.max}
        value={value}
        onChange={value => {
          setValue(value);
        }}/>

      <input
        className= {styles.input}
        min={props.min}
        max={props.max}
        value={value[1]}
        onChange={nextValue => {
          const [start, end] = value;
          if (start > nextValue) return;
          setValue([start, nextValue]);
        }}/>
    </div>
  );
}

  export default Range;