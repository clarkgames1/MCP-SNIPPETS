package yourpackage;

import java.awt.Font;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class Buttons extends GuiButton {
	private boolean background;
	int outlineColor;

	public Buttons(int buttonId, int x, int y, int widthIn, int heightIn, boolean hasBackground, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		this.background = hasBackground;
	}
	
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRendererObj;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = this.getHoverState(this.hovered);
            gui.drawRect(xPosition, yPosition, xPosition + width, yPosition + height, 0xAF353535);           
            this.drawHorizontalLine(this.xPosition, this.xPosition + this.width - 1, this.yPosition, outlineColor);
            this.drawHorizontalLine(this.xPosition, this.xPosition + this.width - 1, this.yPosition + this.height - 1, outlineColor);
            this.drawVerticalLine(this.xPosition, this.yPosition + this.height, this.yPosition, outlineColor);
            this.drawVerticalLine(this.xPosition + this.width - 1, this.yPosition + this.height, this.yPosition, outlineColor);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
            	outlineColor = 0xFF303030;
            	if(this.id == 99) {
            		j = 0xFFFF3535;
            	} else {
                j = 16777120;
            	}
            } else {
            	outlineColor = 0xAF000000;
            }

            mc.fontRendererObj.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 10) / 2, j);
        }
    }

}

