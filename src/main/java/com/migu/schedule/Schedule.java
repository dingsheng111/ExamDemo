package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 类名和方法不能修改
 */
public class Schedule
{
    /**
     * 存放服务节点信息
     */
    private List<Integer> serviceInfo = new ArrayList<Integer>();

    /**
     * 存放任务信息
     */
    private Map<Integer, Integer> taskInfo = new HashMap<Integer, Integer>();

    /**
     * 系统初始化，清空所有数据
     *
     * @return
     */
    public int init()
    {
        serviceInfo.clear();
        taskInfo.clear();
        return ReturnCodeKeys.E001;
    }

    /**
     * 服务节点注册
     *
     * @param nodeId
     * @return
     */
    public int registerNode(int nodeId)
    {
        if (nodeId <= 0)
        {
            return ReturnCodeKeys.E004;
        }

        if (serviceInfo.contains(nodeId))
        {
            return ReturnCodeKeys.E005;
        }

        serviceInfo.add(nodeId);
        return ReturnCodeKeys.E003;
    }

    /**
     * 服务节点注销
     *
     * @param nodeId
     * @return
     */
    public int unregisterNode(int nodeId)
    {
        if (nodeId <= 0)
        {
            return ReturnCodeKeys.E004;
        }

        if (!serviceInfo.contains(nodeId))
        {
            return ReturnCodeKeys.E007;
        }

        serviceInfo.remove(Integer.valueOf(nodeId));
        return ReturnCodeKeys.E006;
    }

    /**
     * 添加任务
     *
     * @param taskId
     * @param consumption
     * @return
     */
    public int addTask(int taskId, int consumption)
    {
        if (taskId <= 0)
        {
            return ReturnCodeKeys.E009;
        }

        if (taskInfo.containsKey(taskId))
        {
            return ReturnCodeKeys.E010;
        }

        taskInfo.put(taskId, consumption);
        return ReturnCodeKeys.E008;
    }


    /**
     * 删除任务
     *
     * @param taskId
     * @return
     */
    public int deleteTask(int taskId)
    {
        if (taskId <= 0)
        {
            return ReturnCodeKeys.E009;
        }
        if (!taskInfo.containsKey(taskId))
        {
            return ReturnCodeKeys.E012;
        }

        taskInfo.remove(taskId);
        return ReturnCodeKeys.E011;
    }


    public int scheduleTask(int threshold)
    {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }


    public int queryTaskStatus(List<TaskInfo> tasks)
    {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

}
