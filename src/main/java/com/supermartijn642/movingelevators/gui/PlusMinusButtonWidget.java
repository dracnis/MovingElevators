package com.supermartijn642.movingelevators.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import com.supermartijn642.core.gui.ScreenUtils;
import com.supermartijn642.core.gui.widget.AbstractButtonWidget;
import com.supermartijn642.core.gui.widget.IHoverTextWidget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.function.Supplier;

/**
 * Created 05/02/2022 by SuperMartijn642
 */
public class PlusMinusButtonWidget extends AbstractButtonWidget implements IHoverTextWidget {

    private static final ResourceLocation PLUS_MINUS_BUTTONS = new ResourceLocation("movingelevators", "textures/gui/plus_minus_buttons.png");

    private final boolean isPlus;
    private final ITextComponent hoverText;
    private final Supplier<Boolean> isActive;

    public PlusMinusButtonWidget(int x, int y, boolean isPlus, ITextComponent hoverText, Supplier<Boolean> isActive, Runnable onPress){
        super(x, y, 11, 11, onPress);
        this.isPlus = isPlus;
        this.hoverText = hoverText;
        this.isActive = isActive;
    }

    @Override
    public ITextComponent getHoverText(){
        return this.hoverText;
    }

    @Override
    protected ITextComponent getNarrationMessage(){
        return this.hoverText;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks){
        this.active = this.isActive.get();
        GlStateManager._enableAlphaTest();
        ScreenUtils.bindTexture(PLUS_MINUS_BUTTONS);
        ScreenUtils.drawTexture(this.x, this.y, this.width, this.height, this.isPlus ? 0 : 1 / 2f, this.active ? this.hovered ? 1 / 3f : 0 : 2 / 3f, 1 / 2f, 1 / 3f);
    }
}
