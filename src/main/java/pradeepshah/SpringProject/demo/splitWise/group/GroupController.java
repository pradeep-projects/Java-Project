package pradeepshah.SpringProject.demo.splitWise.group;
import pradeepshah.SpringProject.demo.splitWise.user.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;
    public GroupController(){
        groupList = new ArrayList<>();
    }

    // create new group
    public void createNewGroup(String groupId, String groupName, User createdByUser){
        // create a new group
        Group group  = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);

        // add the user in the group as created by user
        group.addMember(createdByUser);
        groupList.add(group);
    }

    public Group getGroup(String groupId){

        for(Group group: groupList) {

            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

}
