package com.cn.piaware_storm.topology;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This spout emits 5 "Hello World" strings
 */
public class HelloWorldx5 extends BaseRichSpout {
    private SpoutOutputCollector outputCollector;
    private List<String> hwList;
    private int iteration = 0;

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("hws"));
    }

    public void open(Map map, TopologyContext context, SpoutOutputCollector outputCollector) {
        this.outputCollector = outputCollector;
        //List<MyType> myList = new ArrayList<MyType>();
        //hwList[0] = "Hello World";
        //
        //hwList = new ArrayList<String>();
        // List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        hwList = Arrays.asList("Hello World-1", "Hello World-2", "Hello World-3", "Hello World-4", "Hello World-5");
    }

    public void nextTuple() {
        this.iteration++;
        for (String hw : hwList) {
            //hww = hw + "_" + Integer.toString(this.iter)
            String hww = hw + "-" + Integer.toString(this.iteration);
            outputCollector.emit(new Values(hww));
        }
        //Utils.sleep(1000);
        int a = 7;
    }
}
