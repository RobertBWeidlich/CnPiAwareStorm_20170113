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
        hwList = Arrays.asList("Hello World-1", "Hello World-2", "Hello World-3", "Hello World-4", "HelloWorld-5");
    }

    public void nextTuple() {
        for (String hw : hwList) {
            outputCollector.emit(new Values(hw));
        }
    }
}
