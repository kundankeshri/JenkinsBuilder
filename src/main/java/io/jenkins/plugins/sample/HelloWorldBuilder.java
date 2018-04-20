package io.jenkins.plugins.sample;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.util.ListBoxModel;
import hudson.util.ListBoxModel.Option;
import hudson.views.ViewsTabBar;
import hudson.views.ViewsTabBarDescriptor;
import net.sf.json.JSONObject;

public class HelloWorldBuilder extends ViewsTabBar {
private final String local;
	@DataBoundConstructor
		  public HelloWorldBuilder(String local){
		    this.local = local;
		  }

    @Extension
    public static final class CustomViewsTabBarDescriptor extends ViewsTabBarDescriptor {

        @Override
        public String getDisplayName() {
            return "Custom View Tabs";
        }
        private String tabColour = "00ff00" ;
        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
        	labelText = formData.getString("labelText");
            tabColour = formData.getString("tabColour");
           // String tabUserName = formData.getString("tabUserName");
        	save();
           return super.configure(req, formData);
        }

				public ListBoxModel doFillTabColourItems(){
					    return new ListBoxModel(
					    		new Option("Green", "00ff00", tabColour.equals("00ff00")),
					    	    new Option("Yellow", "ffff00", tabColour.equals("ffff00")),
					    	    new Option("Red", "ff0000", tabColour.equals("ff0000")));
					}
				private String labelText = "initial";

				public String getLabelText(){
				    return labelText;
				}

			public ListBoxModel doFillTabUserNameItems () {
				return new ListBoxModel(
						new Option("kundan","keshri",true),
				        new Option("Nishant","kumar",false));

			}
}
}
