package net.liangyihui.manager.kypt.bos.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum TaskEnum {

    REGISTER("register", "完成注册");

    public String taskCode;

    public String taskName;

    public static final List<TaskEnum> taskList = new ArrayList<>();

    public static final List<String> taskNameList = new ArrayList<>();

    public static final List<String> taskCodeList = new ArrayList<>();

    static {
        taskList.add(REGISTER);

        taskNameList.addAll(taskList.stream().map(item -> item.taskName).collect(Collectors.toList()));
        taskCodeList.addAll(taskList.stream().map(item -> item.taskCode).collect(Collectors.toList()));
    }

    TaskEnum(String taskCode, String taskName) {
        this.taskCode = taskCode;
        this.taskName = taskName;
    }


}
