package yourpackage;
import java.io.IOException;

import net.minecraft.client.gui.*;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;

public class MainMenu extends GuiScreen{

	public GuiMainMenu guiMainMenu;
	
	@Override
	public void initGui() {
		this.buttonList.add(new Buttons(1, this.width / 2 - 75, height / 2, 150, 20, true, I18n.format("menu.singleplayer", new Object[0])));
		this.buttonList.add(new Buttons(2, this.width / 2 - 75, height / 2 + 22, 150, 20, true, I18n.format("menu.multiplayer", new Object[0])));
		this.buttonList.add(new Buttons(3, this.width - 70, 4, 48, 16, false, "Options"));
		this.buttonList.add(new Buttons(5, this.width - 23, 3, 20, 20, true, "?"));
		this.buttonList.add(new Buttons(4, this.width - 120, 4, 48, 16, false, "Language"));
		this.buttonList.add(new Buttons(5, this.width / 2 + 13, height / 2 + 95, 20, 20, true, I18n.format("", new Object[0])));
		super.initGui();	
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		ScaledResolution scaledRes = new ScaledResolution(mc);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("client/bg.png"));
		Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, width,height);
		super.drawScreen(mouseX, mouseY, partialTicks);
		mc.fontRendererObj.drawStringWithShadow("Copyright Mojang AB. Do not distribute!", width - mc.fontRendererObj.getStringWidth("Copyright Mojang AB. Do not distribute!") - 2, height - mc.fontRendererObj.FONT_HEIGHT - 2, -1);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id) {
		case 1: mc.displayGuiScreen(new GuiSelectWorld(this));
			break;
		case 2: mc.displayGuiScreen(new GuiMultiplayer(this));
			break;
		case 3: mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
			break;
		case 4: mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
			break;
		case 5: mc.shutdown();
			break;
		case 6: mc.displayGuiScreen(new ClickGUI());
		}
		super.actionPerformed(button);
	}

}
