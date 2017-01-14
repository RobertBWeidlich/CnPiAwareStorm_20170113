package com.cn.piaware_storm;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        int argc = args.length;

        if (argc < 1) {
            //System.err.println("usage: ")
            System.err.println("ERROR: specify URL");
            System.exit(1);
        }

        System.out.println("argc: " + Integer.toString(argc));

        LocalTopologyRunner ltr = new LocalTopologyRunner(args[0]);
        ltr.run();

        System.exit(0);
    }
}
