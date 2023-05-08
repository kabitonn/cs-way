package com.vika.way.spring.integration.base;

import com.alibaba.film.component.speedup.core.SpeedUp;
import com.alibaba.film.component.speedup.core.speed.AbstractAction;

import java.io.IOException;

/**
 *
 * @author chenwei.tjw
 * @date 2023/2/9
 **/
public class SpeedUpServer {
    public static void main(String[] args) {
        try {
            CWAction action = new CWAction();
            SpeedUp.run(args, action);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class CWAction extends AbstractAction {
        @Override
        public void onJvmStart() throws IOException {

        }

        @Override
        public void onJvmExit() throws IOException {

        }
    }
}
