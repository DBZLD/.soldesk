import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import ChartLine from './ChartLine';
import ChartBar from './ChartBar';
import ChartPie from './ChartPie';
import ChartArea from './ChartArea';
import ChartComposed from './ChartComposed';
import ChartRadar from './ChartRadar';
import ChartRadialBar from './ChartRadialBar';
import ChartScatter from './ChartScatter';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ChartLine />
    <ChartBar />
    <ChartPie />
    <ChartArea />
    <ChartComposed />
    <ChartRadar />
    <ChartRadialBar />
    <ChartScatter />
  </React.StrictMode>
);
