package View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import libPlayGround.Ball;
import libPlayGround.Conf;
import libPlayGround.GameType;

/**
 * Created by Cezar on 03/01/2016.
 */
public class JoaoBoboImgView extends ImageView
{
    public Ball vo_BallConfiguracao;
    private RectF oval;
    private String DEBUGANDO = "DEBUGANDO";
    public int raioTela = 70;
    private int raioCabeca = raioTela - 20;
    public boolean vb_PrimeiraExecucao;
    public int clicouQualquerBolinha = 0;
    public Random numRand;
    private Context mContext;
    public Paint ptBolinha = new Paint();
    public Handler h;
    public int frame_rate = 5;
    public boolean vbTrocarNota;
    public GameType vo_Campo;
    public boolean vbParar = false;
    public boolean vb_Acertou = false;
    public String vs_NotaProcurada = "";
    public Context contexto_app;
    public int valorTotalErros = 6;
    private int xMoveCabeca = 0;
    private int xOlhoDireito = 33;
    private int xOlhoEsquerdo = 5;
    private int yOlhosDireito = -15;
    private int yOlhosEsquerdo = -15;
    private int botomBoca = 0;

    public Conf vo_conf;
    public Typeface tf;
    public boolean vbAparencia;
    private int _corPrimaria ;
    private int _corSecundaria;
    // Movimento do Joao Bobo
    private int anguloInicial = 0;
    private int angulo = 180;
    private int anguloInicialSuperior = -180;
    private int anguloSuperior = 180;
    private boolean vbTombarDireita = false;
    private boolean vbTombarEsquerda = false;
    public int xCabeca = 145;
    public int yCabeca = 100;
    private TextView txtMensagem;

    public JoaoBoboImgView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        contexto_app = context;
        mContext = context;
        vbTombarDireita = true;
        vbTombarEsquerda = false;
    }
    public void balancaJoaoBobo()
    {
        /*if(vbTombarDireita){ xCabeca--;anguloInicial--; angulo--;anguloInicialSuperior--;anguloSuperior--; }
        if(vbTombarEsquerda){xCabeca++; anguloInicial++; angulo++;
                            anguloInicialSuperior++;anguloSuperior++;}
        if(angulo < 175){ vbTombarDireita = false; vbTombarEsquerda = true;}
        if(angulo > 185){ vbTombarDireita = true; vbTombarEsquerda = false;}*/
        if (vbTombarDireita)
        {
            anguloInicial--;
            angulo--;
            anguloInicialSuperior--;
            anguloSuperior--;
            xMoveCabeca--;
            xOlhoEsquerdo++;
            xOlhoDireito--;
            botomBoca--;
        }

        if (vbTombarEsquerda)
        {
            anguloInicial++;
            angulo++;
            anguloInicialSuperior++;
            anguloSuperior++;
            xMoveCabeca++;
            xOlhoEsquerdo--;
            xOlhoDireito++;
            botomBoca++;
        }

        if (angulo < 178)
        {
            vbTombarDireita = false;
            vbTombarEsquerda = true;
        }

        if (angulo > 183)
        {
            vbTombarDireita = true;
            vbTombarEsquerda = false;
        }
        h.postDelayed(r, frame_rate);
    }
    public void preConfiguraJogo(Conf a_Conf,GameType va_Campo)
    {
        numRand = new Random();
        vo_conf = a_Conf;
        vo_Campo = va_Campo;
        // frame_rate = vo_conf.getVi_FrameRate();
        this.iniciaJogo();
    }
    public void iniciaTelaConfiguracao(Conf aConf)
    {
        vo_conf = aConf;
        h = new Handler();
    }
    public void iniciaJogo()
    {
        // Libera algumas notas
        vo_Campo.preConfiguraPlacar();
        // Formata o Layout
        formataLayout();
        // -------------------------------------------------------------------------------------
        vo_Campo.geraConteudoBolinhas();
        // Cria os objetos necessarios para o sistema criar o movimento das bolinhas.
        criaThreadsParaMovimento();
    }
    private void criaThreadsParaMovimento() {
        vbParar = false;
        h.postDelayed(r, frame_rate);
    }
    private void formataLayout()
    {
        ptBolinha.setTextAlign(Paint.Align.CENTER);
    }
    public Runnable r = new Runnable()
    {
        @Override
        public void run(){invalidate();}
    };
    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas c)
    {
        configuraTamanhoBolinha(c);
        conf(c);
    }
    private void conf(Canvas c)
    {
        float mid = vo_BallConfiguracao.get_xBolinha();
        float min = (vo_BallConfiguracao.get_yBolinha() - 100);
        float half = min / 2;
        ptBolinha.setStyle(Paint.Style.STROKE);
        ptBolinha.reset();
    }
    private void configuraTamanhoBolinha(Canvas c)
    {
        vo_BallConfiguracao = new Ball();
        criaCorpo(c);
        h.postDelayed(r, frame_rate);
    }
    private void criaBoca(Canvas c,boolean vb_sorrisoAlegre)
    {
        ptBolinha.setColor(Color.BLACK);
        float cantinhoBoca, right = 0;
        oval = new RectF();
        cantinhoBoca = (getWidth() / 2) - raioTela + 32;
        right = (getWidth() / 2) + raioTela - 40;
        float top = (getHeight() / 4) - raioTela;
        float bottom = (((getHeight() / 4)) + raioTela) - 20;
        oval.set((cantinhoBoca), top + 54, (right + 10), (bottom));
        c.drawArc(oval,0 + botomBoca, 180, false, ptBolinha);
    }
    private void criaCorpo(Canvas c)
    {
        ptBolinha.setColor(Color.YELLOW);
        c.drawCircle((getWidth() / 2 ) + xMoveCabeca, yCabeca, raioCabeca, ptBolinha);
        vo_BallConfiguracao.set_xBolinha(getWidth() / 2);
        vo_BallConfiguracao.set_yBolinha(getHeight() / 2);
        oval = new RectF();
        oval.set((vo_BallConfiguracao.get_xBolinha()) - raioTela,
                vo_BallConfiguracao.get_yBolinha() - raioTela,
                (vo_BallConfiguracao.get_xBolinha()) + raioTela,
                vo_BallConfiguracao.get_yBolinha() + raioTela);

        c.drawArc(oval, anguloInicialSuperior, anguloSuperior, false, ptBolinha);
        ptBolinha.setColor(Color.GREEN);
        c.drawArc(oval, anguloInicial, angulo, false, ptBolinha);
        ptBolinha.setColor(Color.BLACK);
        ptBolinha.setStrokeWidth(5);

        c.drawCircle(xCabeca + xOlhoDireito, yCabeca + yOlhosDireito,
                (raioCabeca - 20) / 4, ptBolinha);

        c.drawCircle(xCabeca - xOlhoEsquerdo, yCabeca + yOlhosEsquerdo,
                (raioCabeca - 20) / 4, ptBolinha);

        criaBoca(c, true);
    }
    private void criaOlhos(Canvas c)
    {
        ptBolinha.setColor(Color.BLACK);
        c.drawCircle(xCabeca + 15, yCabeca, (raioCabeca - 20) / 4, ptBolinha);
        c.drawCircle(xCabeca - 15,yCabeca, (raioCabeca - 20) / 4, ptBolinha);
    }
    public int get_corPrimaria() {
        return _corPrimaria;
    }
    public void set_corPrimaria(int _corPrimaria) {
        this._corPrimaria = _corPrimaria;
    }
    public int get_corSecundaria() {
        return _corSecundaria;
    }
    public void set_corSecundaria(int _corSecundaria) {
        this._corSecundaria = _corSecundaria;
    }
}

